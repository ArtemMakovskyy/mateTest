package main.jdbc.databapractice;

import main.jdbc.databapractice.dao.TeaSortsDao;
import main.jdbc.databapractice.dao.TeaSortsDaoImpl;
import main.jdbc.databapractice.model.TeaSort;

public class Main {
    public static void main(String[] args) {
        TeaSortsDao teaSortsDao = new TeaSortsDaoImpl();

//        TeaSort princesNuri = teaSortsDao.create(new TeaSort("Princes Nuri", 14.6));
//        System.out.println(princesNuri);

        System.out.println(teaSortsDao.get(1L));
        System.out.println(teaSortsDao.get("Lipton"));

    }
}
