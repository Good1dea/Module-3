package com.sydoruk;

import com.sydoruk.util.Menu;
import com.sydoruk.config.HibernateUtil;

public class Main {

    public static void main(String[] args){

        HibernateUtil.migrationDB();
        Menu menu = Menu.getInstance();
        menu.userChoice();
        }
    }