package model.login;

import model.person.Person;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Login {
    //Properties--------------------------------------------------------------------------------------------------------
    private final List<String> stateList = Arrays.asList
            ("Wien", "Vorarlberg", "Tirol", "Salzburg", "Kaernten", "Steiermark", "Oberoesterreich",
                    "Niederoesterreich", "Burgenland");

    //StateGetter--------------------------------------------------------------------------------------------------------
    public List<String> getStateList() {
        return stateList;
    }

    //======================TXT Writer-Reader======================
    //FileWriter--------------------------------------------------------------------------------------------------------
    public void userSave(long id, String name, int age, char gender, String state, char[] password) {
        try {
            FileWriter user = new FileWriter("user1.txt");
            user.write(id + " " + name + " " + age + " " + gender + " " + state + " " + password);
            user.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("\nUser " + name + " is saved");
    }

    //FileReader--------------------------------------------------------------------------------------------------------
    public void userRead() throws Exception {
        FileReader fr = new FileReader("user1.txt");
        int i;
        while ((i = fr.read()) != -1)
            System.out.print((char) i);
        fr.close();
    }

    //InfoGetter Methods------------------------------------------------------------------------------------------------
    public String getName() {
        String[] userInfo = {};
        try (FileReader fileReader = new FileReader("user1.txt")) {
            try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                String user = bufferedReader.readLine();
                userInfo = user.split("[ ]+");
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        String name = userInfo[1];
        return name;
    }

    public int getAge() {
        String[] userInfo = {};
        try (FileReader fileReader = new FileReader("user1.txt")) {
            try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                String user = bufferedReader.readLine();
                userInfo = user.split("[ ]+");
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        int age = Integer.parseInt(userInfo[2]);
        return age;
    }

    public String getGender() {
        String[] userInfo = {};
        try (FileReader fileReader = new FileReader("user1.txt")) {
            try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                String user = bufferedReader.readLine();
                userInfo = user.split("[ ]+");
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        String gender = userInfo[3];
        return gender;
    }

    //======================SERIALIZATION======================
    //Serialization-----------------------------------------------------------------------------------------------------
    public void userCreate(long id, String name, int age, char gender, String state, char[] password) {
        try {
            Person person = new Person(id, name, age, gender, state, password);
            ObjectOutputStream fileInOut = new ObjectOutputStream(new FileOutputStream("user2.ser"));
            fileInOut.writeObject(person);
            fileInOut.flush();
            fileInOut.close();
            System.out.println("\nSerialized data are saved in user2.ser");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //Deserialization---------------------------------------------------------------------------------------------------
    public void userConfirm() {
        Person person;
        try {
            ObjectInputStream fileIn = new ObjectInputStream(new FileInputStream("user2.ser"));
            person = (Person) fileIn.readObject();
            fileIn.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Person class not found or Password is incorrect.");
            c.printStackTrace();
            return;
        }
        System.out.println("\nDeserialized data: " + person);
    }

    //InfoGetter Methods------------------------------------------------------------------------------------------------
//    public String getName() {
//        Person person;
//        try {
//            ObjectInputStream fileIn = new ObjectInputStream(new FileInputStream("user2.ser"));
//            person = (Person) fileIn.readObject();
//            fileIn.close();
//            return person.getName();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        } catch (ClassNotFoundException c) {
//            c.printStackTrace();
//        }
//        return "";
//    }
//
//    public int getAge() {
//        Person person;
//        try {
//            ObjectInputStream fileIn = new ObjectInputStream(new FileInputStream("user2.ser"));
//            person = (Person) fileIn.readObject();
//            fileIn.close();
//            return person.getAge();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        } catch (ClassNotFoundException c) {
//            c.printStackTrace();
//        }
//        return 0;
//    }
//
//    public String getGender() {
//        Person person;
//        try {
//            ObjectInputStream fileIn = new ObjectInputStream(new FileInputStream("user2.ser"));
//            person = (Person) fileIn.readObject();
//            fileIn.close();
//            return String.valueOf(person.getGender());
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        } catch (ClassNotFoundException c) {
//            c.printStackTrace();
//        }
//        return "";
//    }
//}
//======================DATABASE======================
    //Adding------------------------------------------------------------------------------------------------------------
//    private Database myDatabase = new Database();
//
//    public void addUser(long id, String username, int age, char gender, String state, char[] password){
//    try {
//        myDatabase.myConnect("com.mysql.jdbc.Driver",
//                "jdbc:mysql://localhost/dbInfoAustria?user=root");
//        String temp = myDatabase.myInsert(id, username, age, gender, state, password);
//        System.out.println(temp);
//        myDatabase.myClose();
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
//    this.showUser();
//}

//  //Reading------------------------------------------------------------------------------------------------------------
//    private void showUser(){
//        try {
//            myDatabase.myConnect("com.mysql.jdbc.Driver",
//                    "jdbc:mysql://localhost/dbInfoAustria?user=root");
//            ResultSet rs = myDatabase.myQuery("select * from tblUsers");
//
//            while(rs.next()){
//                System.out.println(rs.getInt("id") + " "
//                        + rs.getString("username")
//                        + rs.getInt("age")
//                        + rs.getString("gender")
//                        + rs.getString("state")
//                        + rs.getString("password"));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}