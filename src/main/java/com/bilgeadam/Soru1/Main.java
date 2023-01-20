package com.bilgeadam.Soru1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        // save metodunu istemediğiniz için yazmadım kontrol amaçlı
        // database eklediğim bilgiler üzerinden metodlarımı kontrol ettim
        //getCalisan();
        Calisan calisan =new Calisan(2,"update1",22,333,"aaa",new Sirket(1));
       // update(calisan);
        Calisan calisan1 = new Calisan(2);
        delete(calisan1);
    }
    static DB db = new DB();
    static List<Calisan> calisanList = new ArrayList<>();
    public static void getCalisan() throws SQLException {
        String sql = "SELECT c.id,c.sid,c.isim,c.yas,c.maas,c.departman,s.id,s.sirketismi,s.sirketsahibi,s.unvan,s.faaliet,s.kurulus FROM sirket_calisan.calisan as c\n" +
                "inner join sirket_calisan.sirket as s \n" +
                "on c.sid = s.id";
        PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()){
            String isim = rs.getString("isim");
            int yas = rs.getInt("yas");
            int maas = rs.getInt("maas");
            String departman = rs.getString("departman");
            String sirketismi = rs.getString("sirketismi");
            String sirketsahibi = rs.getString("sirketsahibi");
            String unvan = rs.getString("unvan");
            String faaliet = rs.getString("faaliet");
            String kurulus = rs.getString("kurulus");
            Calisan calisan = new Calisan(isim,yas,maas,departman,new Sirket(sirketismi,sirketsahibi,unvan,faaliet,kurulus));
            calisanList.add(calisan);
        }
        if (calisanList.isEmpty()){
            System.out.println("Boş");
        }else {
            calisanList.forEach(System.out::println);
        }
    }
    public static void update(Calisan calisan){
        String sql = "UPDATE sirket_calisan.calisan SET sid= ?, isim = ?, yas = ?, maas = ?, departman = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            preparedStatement.setInt(1, calisan.getSirket().getId());
            preparedStatement.setString(2, calisan.getIsim());
            preparedStatement.setInt(3, calisan.getYas());
            preparedStatement.setInt(4, calisan.getMaas());
            preparedStatement.setString(5, calisan.getDepartman());
            preparedStatement.setInt(6, calisan.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            getCalisan();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void delete(Calisan calisan){
        String sql = "delete from sirket_calisan.calisan WHERE id = ?";
        try {
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            preparedStatement.setInt(1, calisan.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            System.out.println("Calısan silindi");
            getCalisan();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
