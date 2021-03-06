package com.cuipengyu.greendaodemo.db;

import android.support.annotation.NonNull;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.DaoException;

/**
 * Create by    ： 崔鹏宇
 * Time  is     ： 2018/5/18
 * Email        ： cuipengyusoul@gmail.com
 * Github       ： https://github.com/SolitarySoul
 * Instructions ：
 */
@Entity
public class User {
    @Id
    private Long id;
    @Property(nameInDb = "Name")
    @NonNull
    @Unique
    private String name;
    @NonNull
    private String passWord;
    @Transient
    private String Transient;
    private Long bookid;
    @ToOne(joinProperty = "bookid")
    private Book mBook;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1507654846)
    private transient UserDao myDao;
    @Generated(hash = 1172141333)
    public User(Long id, @NonNull String name, @NonNull String passWord,
            Long bookid) {
        this.id = id;
        this.name = name;
        this.passWord = passWord;
        this.bookid = bookid;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassWord() {
        return this.passWord;
    }
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    public Long getBookid() {
        return this.bookid;
    }
    public void setBookid(Long bookid) {
        this.bookid = bookid;
    }
    @Generated(hash = 1191756649)
    private transient Long mBook__resolvedKey;
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1781247597)
    public Book getMBook() {
        Long __key = this.bookid;
        if (mBook__resolvedKey == null || !mBook__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            BookDao targetDao = daoSession.getBookDao();
            Book mBookNew = targetDao.load(__key);
            synchronized (this) {
                mBook = mBookNew;
                mBook__resolvedKey = __key;
            }
        }
        return mBook;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1331913699)
    public void setMBook(Book mBook) {
        synchronized (this) {
            this.mBook = mBook;
            bookid = mBook == null ? null : mBook.getBookId();
            mBook__resolvedKey = bookid;
        }
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 2059241980)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getUserDao() : null;
    }


}
