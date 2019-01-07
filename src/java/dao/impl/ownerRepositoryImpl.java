package dao.impl;

import dao.entity.productOwner;
import dao.ownerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Component
public class ownerRepositoryImpl implements ownerRepository {
    @Autowired
    private dao.dataSource dataSource;

    @Override
    public long create(productOwner productOwner) {
        return 0;
    }

    @Override
    public void update(productOwner productOwner) {

    }

    @Override
    public productOwner getOne(long id) {
        return null;
    }

    @Override
    public List<productOwner> findAll() {
        List<productOwner> result = new ArrayList<productOwner>();
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_ALL);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                productOwner productOwner = new productOwner();
                productOwner.setId(rs.getLong(productOwner.ID_COLUMN));
                productOwner.setFirstName(rs.getString(productOwner.FIRSTNAME_COLUMN));
                result.add(productOwner);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dataSource.closeConnection(connection);
        }
        return result;
    }
}
