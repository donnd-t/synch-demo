package com.donnd.synchdemo.integration.customer.endpoint.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.donnd.synchdemo.integration.customer.domain.Customer;

@Component
public class CustomerRowMapper implements RowMapper<Customer> {
 
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Customer(rs.getString("name"));
    }

}
