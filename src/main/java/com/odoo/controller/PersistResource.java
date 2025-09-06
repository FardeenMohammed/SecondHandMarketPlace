package com.odoo.controller;

import com.odoo.dto.CartModel;
import com.odoo.dto.ProductModel;
import io.vertx.sqlclient.Pool;
import io.vertx.sqlclient.Tuple;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

//@Controller
//public class PersistResource {
//    private final Pool client;
//
//    public PersistResource(Pool client) {
//        this.client = client;
//    }
//
//    @PostMapping("/api/cart/insert")
//    public Mono<String> insertCartData(@RequestBody CartModel data) {
//        String baseQuery = "INSERT INTO cart (userId, productId, active) VALUES (?,?,?)";
//        Tuple insertionData = Tuple.tuple()
//                .addString(data.getUser_id())
//                .addString(data.getProduct_id())
//                .addBoolean(data.getActive());
//        return Mono.create(sink -> {
//            client.preparedQuery(baseQuery)
//                    .execute(insertionData)
//                    .onComplete(ar -> {
//                        if (ar.succeeded()) sink.success("Insert successful");
//                        else sink.error(ar.cause());
//                    })
//                    .onFailure(err -> {
//                        sink.error(err.getCause());
//                    })
//            ;
//
//        });
//    }

//    @PostMapping("/api/insert2")
//    public Mono<String> insertData2(@RequestBody DataDto data) {
//        return Mono.create(sink -> {
//            client.preparedQuery("INSERT INTO table2 (field2) VALUES (?)")
//                    .execute(Tuple.of(data.getField2()))
//                    .onComplete(ar -> {
//                        if (ar.succeeded()) sink.success("Insert successful");
//                        else sink.error(ar.cause());
//                    });
//        });
//    }
//}

@RestController
public class PersistResource {
    private final Pool client;

    public PersistResource(Pool client) {
        this.client = client;
    }

    @PostMapping("/api/cart/insert")
    public Mono<String> insertCartData(@RequestBody CartModel data) {
        String baseQuery = "INSERT INTO cart (userId, productId, active) VALUES (?, ?, ?)";
        Tuple insertionData = Tuple.tuple()
                .addString(data.getUser_id())
                .addString(data.getProduct_id())
                .addBoolean(data.getActive());
        return Mono.create(sink -> {
            client.preparedQuery(baseQuery)
                    .execute(insertionData)
                    .onComplete(ar -> {
                        if (ar.succeeded()) sink.success("Insert successful");
                        else sink.error(ar.cause());
                    });
        });
    }

    @PostMapping("/api/product/insert")
    public Mono<String> insertProductData(@RequestBody ProductModel data) {
        String baseQuery = "INSERT INTO Product (productId, title, description, category, price, imagePlaceholder, userId, is_purchase, metaData, active) VALUES (?,?,?,?,?,?,?,?,?,?)";
        Tuple insertionData = Tuple.tuple()
                .addString(data.getProductId())
                .addString(data.getTitle())
                .addString(data.getDescription())
                .addString(data.getCategory())
                .addFloat(data.getPrice())
                .addString(data.getImagePlaceholder())
                .addString(data.getUserId())
                .addBoolean(data.getIs_purchase())
                .addString(data.getMetaData())
                .addBoolean(data.getActive());
        return Mono.create(sink -> {
            client.preparedQuery(baseQuery)
                    .execute(insertionData)
                    .onComplete(ar -> {
                        if (ar.succeeded()) sink.success("Insert successful");
                        else sink.error(ar.cause());
                    });
        });
    }
}