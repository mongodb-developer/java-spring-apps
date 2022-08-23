package com.mongodb.examples.springdatabulkinsert;

public interface CustomProductsRepository {
    void updateProductQuantity(String name, int newQty)  ;
    int bulkInsertProducts(int count);
}
