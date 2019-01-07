package dao.impl;

import dao.entity.items;
import dao.itemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class itemRepositoryImpl implements itemRepository {
    @Autowired
    private dao.dataSource dataSource;

    @Override
    public long create(items items) {
        return 0;
    }

    @Override
    public void update(items items) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE);
            statement.setString(1, items.getTitle());
            statement.setLong(2, items.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dataSource.closeConnection(connection);
        }
    }

    @Override
    public items getOne(long id) {
        return null;
    }

    @Override
    public List<items> findAll() {
        List<items> result = new ArrayList<items>();
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_ALL);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                items item = new items();
                item.setId(rs.getLong(items.ID_COLUMN));
                item.setTitle(rs.getString(items.TITLE_COLUMN));
                result.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dataSource.closeConnection(connection);
        }
        return result;
    }
}
