package com.cbs.edu.eshop.repository.impl;

import com.cbs.edu.eshop.entity.Role;
import com.cbs.edu.eshop.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.util.HashMap;
import java.util.List;

public class RoleRepository implements IRoleRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public RoleRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Role get(Integer id) {
        String sql = "SELECT * FROM roles WHERE id = :id";

        HashMap<String, String> params = new HashMap<>();
        params.put("id", String.valueOf(id));

        return jdbcTemplate.queryForObject(sql, params, Role.class);
    }

    @Override
    public Role create(Role entity) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", String.valueOf(entity.getId()));
        parameterSource.addValue("name", entity.getName());

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update("INSERT INTO roles(id, name) VALUES (:id, :name)", parameterSource, keyHolder);

        entity.setId((Integer) keyHolder.getKey());

        return entity;
    }

    @Override
    public Role update(Role entity) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Role> getAll() {
        return null;
    }

    @Override
    public Role getByName(String name) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("name", name);

        return jdbcTemplate.queryForObject("SELECT * FROM roles WHERE name = :name", parameterSource, (resultSet, rowNum) -> {
            Role role = new Role();
            role.setId(resultSet.getInt("id"));
            role.setName(resultSet.getString("role_name"));

            return role;
        });
    }
}
