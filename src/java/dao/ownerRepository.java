package dao;

import dao.entity.items;
import dao.entity.productOwner;

import java.util.List;

public interface ownerRepository {
    public static final String SQL_FIND_ALL = "select * from " + productOwner.TABLE_NAME;
    long create(productOwner productOwner);
    void update(productOwner productOwner);
    productOwner getOne(long id);
    List<productOwner> findAll();

}
