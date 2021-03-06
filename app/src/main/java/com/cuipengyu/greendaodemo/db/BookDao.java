package com.cuipengyu.greendaodemo.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "BOOK".
*/
public class BookDao extends AbstractDao<Book, Long> {

    public static final String TABLENAME = "BOOK";

    /**
     * Properties of entity Book.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property BookId = new Property(0, Long.class, "bookId", true, "_id");
        public final static Property BookName = new Property(1, String.class, "bookName", false, "BOOK_NAME");
    }


    public BookDao(DaoConfig config) {
        super(config);
    }
    
    public BookDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"BOOK\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: bookId
                "\"BOOK_NAME\" TEXT NOT NULL UNIQUE );"); // 1: bookName
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"BOOK\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Book entity) {
        stmt.clearBindings();
 
        Long bookId = entity.getBookId();
        if (bookId != null) {
            stmt.bindLong(1, bookId);
        }
        stmt.bindString(2, entity.getBookName());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Book entity) {
        stmt.clearBindings();
 
        Long bookId = entity.getBookId();
        if (bookId != null) {
            stmt.bindLong(1, bookId);
        }
        stmt.bindString(2, entity.getBookName());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Book readEntity(Cursor cursor, int offset) {
        Book entity = new Book( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // bookId
            cursor.getString(offset + 1) // bookName
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Book entity, int offset) {
        entity.setBookId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setBookName(cursor.getString(offset + 1));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Book entity, long rowId) {
        entity.setBookId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Book entity) {
        if(entity != null) {
            return entity.getBookId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Book entity) {
        return entity.getBookId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
