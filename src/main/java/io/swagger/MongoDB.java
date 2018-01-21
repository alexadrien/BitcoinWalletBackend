/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.swagger;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import io.swagger.model.Transaction;
import java.math.BigDecimal;
import java.util.LinkedList;
import org.bson.Document;

/**
 *
 * @author alex-adrienauger
 */
public class MongoDB {

    public LinkedList<Transaction> getAllTransactionsFromNickname(String nickname) {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase database = mongoClient.getDatabase("bitcoinwallet");
        MongoCollection<Document> coll = database.getCollection("transactions");

        final LinkedList<Transaction> ll = new LinkedList<Transaction>();

        Block<Document> block = new Block<Document>() {
            @Override
            public void apply(final Document document) {
                Transaction t = new Transaction();
                t.setOwner(document.getString("owner"));
                t.setBtc(Double.valueOf(document.getDouble("btc")));
                t.setUsd(Double.valueOf(document.getDouble("usd")));
                t.setTimestamp(document.getString("timestamp"));
                t.setType(document.getBoolean("type"));
                ll.add(t);
            }
        };

        coll.find(eq("owner", nickname)).forEach(block);
                
        return ll;
    }

    public Boolean insertOneTransation(Transaction t) {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase database = mongoClient.getDatabase("bitcoinwallet");
        MongoCollection<Document> coll = database.getCollection("transactions");

        Document document = new Document("owner", t.getOwner())
                .append("timestamp", t.getTimestamp())
                .append("usd", t.getUsd())
                .append("btc", t.getBtc())
                .append("type", t.isType());

        //if type is true, it's a BUY transaction 
        //if it's false, it's a SELL transaction
        coll.insertOne(document);

        // TODO : send false when a problem occurs
        return true;
    }

}
