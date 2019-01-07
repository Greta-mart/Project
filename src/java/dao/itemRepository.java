package dao;

import dao.entity.items;

import java.util.List;

public interface itemRepository {
    public static final String SQL_FIND_ALL = "select * from " + items.TABLE_NAME;
    public static final String SQL_UPDATE = "update " + items.TABLE_NAME + " set " + items.TITLE_COLUMN + " where " + items.ID_COLUMN + " = ?";
    long create(items items);
    void update(items items);
    items getOne(long id);
    List<items> findAll();
}
