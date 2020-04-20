package babyKun.database;

import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shiqing WuF
 */
public class DataBase {

    /*
    Use embedded database so we can access to it anywhere. 
    It was like a file in the project.
    Make sure the databse is disconnected.
     */
    Connection conn = null;
    String url = "jdbc:derby:EnermyDB; create=true";
    String username = "pdc";
    String password = "pdc";
    Statement statement = null;
    ArrayList<Integer> arr = new ArrayList<Integer>();

    /**
     * Connect to the EnermyDB and create a table for the enemy attributes.
     */
    public void createEnermyDB() {
        try {
            this.conn = DriverManager.getConnection(this.url, this.username, this.password);
            System.out.println("Conneceted...");
            this.statement = conn.createStatement();
            //check if the table is existed.
            this.checkExistedTable("ENERMY");
            this.statement.addBatch("CREATE  TABLE ENERMY  (ENERMYID  INT,   ENERMYNAME   VARCHAR(50),   HEALTH INT,   MANA INT, ATTACK INT, DEFENCE INT, CRITICALCHANCE INT)");
            this.statement.addBatch("INSERT INTO ENERMY VALUES (1, 'Gorilla', 100,0,150,20,50),\n"
                    + "(2, 'Bat', 80,0,140,30,50),\n"
                    + "(3, 'Snake', 150,0,140,30,50),\n"
                    + "(4, 'Scorpion', 50,0,150,100,50),\n"
                    + "(5, 'Skeleton', 10,0,110,10,50),\n"
                    + "(6, 'Pirate', 10,0,110,10,50),\n"
                    + "(7, 'Dragon', 300,0,180,20,50)");
            this.statement.executeBatch();
            System.out.println("Executed SQL statements");
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Connect to the EnermyDB and create a table for the Kun's names.
     */
    public void createNameTable() {
        try {
            this.conn = DriverManager.getConnection(this.url, this.username, this.password);
            System.out.println("Conneceted...");
            this.statement = conn.createStatement();
            //check if any table exists with same name;
            this.checkExistedTable("ALLNAMES");
            this.statement.addBatch("CREATE TABLE ALLNAMES (CNAME VARCHAR(50))");
            this.statement.addBatch("INSERT INTO ALLNAMES VALUES ('Harry Potter'),\n"
                    + "('Raibow Baby'),\n"
                    + "('John Snow'),\n"
                    + "('Michael Jackson'),\n"
                    + "('Bill Gates'),\n"
                    + "('John Snow'),\n"
                    + "('Jay Zhou')");
            this.statement.executeBatch();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Connect to the EnermyDB and create a table for the Kun's attributes.
     */
    public void createCharacterDB() {
        try {
            this.conn = DriverManager.getConnection(this.url, this.username, this.password);
            System.out.println("Conneceted...");
            this.statement = conn.createStatement();
            this.checkExistedTable("KUN");
            //check if any table exists with same name;
            this.statement.addBatch("CREATE  TABLE KUN  (KUNID  INT,   KUNNAME   VARCHAR(50),   HEALTH INT,   MANA INT, ATTACK INT, DEFENCE INT, LUCK INT, CRITICALCHANCE INT)");
            this.statement.addBatch("INSERT INTO KUN VALUES (1, 'Loyal', 200,50,50,120,30,20),\n"
                    + "(2, 'Smart', 200,100,50,100,30,90),\n"
                    + "(3, 'Fashionable', 300,60,80,100,30,20),\n"
                    + "(4, 'Quiet', 200,70,50,100,30,50),\n"
                    + "(5, 'Strong', 250,70,100,100,30,50),\n"
                    + "(6, 'Adorable', 200,80,100,100,50,60)");
            this.statement.executeBatch();
            System.out.println("Executed SQL statements");
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * check if the table is existed, if so delete.
     *
     * @param name - name of the table
     */
    public void checkExistedTable(String name) {
        try {
            DatabaseMetaData dbmd = this.conn.getMetaData();
            String[] types = {"TABLE"};
            ResultSet rs = dbmd.getTables(null, null, null, types);
            Statement statement = this.conn.createStatement();
            while (rs.next()) {
                String table_name = rs.getString("TABLE_NAME");
                System.out.println(table_name);
                if (table_name.equalsIgnoreCase(name)) {
                    statement.executeUpdate("Drop table " + name);
                    System.out.println("Table " + name + " has been deleted.");
                    break;
                }
            }
            rs.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * method to get random names
     *
     * @return a list of names from AllNames table
     */
    public ArrayList<String> RandomName() {

        ArrayList<String> randomName = new ArrayList<String>();

        try {
            ResultSet rs = statement.executeQuery("SELECT CNAME FROM ALLNAMES");
            while (rs.next()) {

                randomName.add(rs.getString(1));

            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

        return randomName;
    }

    /**
     * Method to get a list of attributes for selected enemyName;
     *
     * @param enemyName selected enemyName
     * @return A list of attributes.
     */
    public ArrayList<Integer> EnemyAttributes(String enemyName) {

        ArrayList<Integer> enermyBuild = new ArrayList<Integer>();

        try {

            String sql = "SELECT HEALTH, MANA, ATTACK, DEFENCE, CRITICALCHANCE FROM ENERMY WHERE ENERMYNAME=" + "'" + enemyName + "'";
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                enermyBuild.add(rs.getInt(1));
                enermyBuild.add(rs.getInt(2));
                enermyBuild.add(rs.getInt(3));
                enermyBuild.add(rs.getInt(4));
                enermyBuild.add(rs.getInt(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

        return enermyBuild;
    }

    /**
     * Method to get a list of attributes for selected Kun's characteristic;
     *
     * @param kunCharacter selected Kun's characteristic.
     * @return A list of attributes.
     */
    public ArrayList<Integer> CharacterAttributes(String kunCharacter) {

        ArrayList<Integer> kunBuild = new ArrayList<Integer>();

        try {

            String sql = "SELECT HEALTH, MANA, ATTACK, DEFENCE, LUCK, CRITICALCHANCE FROM KUN WHERE KUNNAME=" + "'" + kunCharacter + "'";
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                kunBuild.add(rs.getInt(1));
                kunBuild.add(rs.getInt(2));
                kunBuild.add(rs.getInt(3));
                kunBuild.add(rs.getInt(4));
                kunBuild.add(rs.getInt(5));
                kunBuild.add(rs.getInt(6));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

        return kunBuild;
    }

    /**
     * Method to get a enemy's name in the enermy table;
     *
     * @return enemy's name
     */
    public ArrayList<String> enermyName() {

        ArrayList<String> enermyName = new ArrayList<String>();

        try {

            ResultSet rs = statement.executeQuery("SELECT ENERMYNAME FROM ENERMY");

            while (rs.next()) {

                enermyName.add(rs.getString(1));

            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

        return enermyName;
    }

}
