package org.example.models;

import java.util.*;

public class Grocery {
    public static ArrayList<String> groceryList = new ArrayList<>();

    public static void main(String[] args) {
        startGrocery();
    }


    public static void removeItems(String itemsToRemove) {
        String[] itemsToRemoveArr= itemsToRemove.split(",");
        for (String item : itemsToRemoveArr){
            String trimmedItem = item.trim();
            if(checkItemIsInList(trimmedItem)){
                groceryList.remove(trimmedItem);
            }
        }
        Collections.sort(groceryList);
    }

    public static void addItems(String itemsToAdd) {
        String[] itemsToAddArr = itemsToAdd.split(",");
        for(String item : itemsToAddArr){
            String trimmedItem = item.trim();
            if(!checkItemIsInList(trimmedItem)){
                groceryList.add(trimmedItem);
            }
        }
        Collections.sort(groceryList);
    }


    // Eleman listede var mı kontrolü yapan metod:
    public static boolean checkItemIsInList(String item){
        if(groceryList.contains(item)){
            return true;
        } return false;
    }


    // Listeyi sıralı olarak ekrana basan metot
    public static void printSorted(){
       Collections.sort(groceryList);
        System.out.println("Alışveriş listesi: ");
        for(String item : groceryList){
            System.out.println(item);
        }
    }

    public static void startGrocery(){
        Scanner scanner = new Scanner(System.in);

        while (true){ // kullanıcı "çıkış" yapana kadar devam edecek işlemler için sonsuz döngü

            System.out.println("Seçim yapınız: 0 - Çıkış, 1 - Ürün ekle, 2 - Ürün çıkar");
            int processNumber = scanner.nextInt(); //nextInt(), sadece girilen int'i alır
            //int girdikten sonra enter'a basıldığında, akışta asılı bir hiçlik karakteri kalır
            scanner.nextLine(); //bu hiçlik karakterini "" alması için bir kez nextLine() kullandık.
            // bknz: Scanner’daki Yeni Satir Karakteri (‘\n’) hatasini giderilmesi

            switch (processNumber){
                case 0:
                    System.out.println("Uygulama durduruluyor...");
                    scanner.close();
                    return;
                case 1:
                    System.out.println("Eklemek istediğiniz ürünleri giriniz");
                    String itemsToAdd = scanner.nextLine();
                    addItems(itemsToAdd);
                    break;
                case 2:
                    System.out.println("Çıkarmak istediğiniz ürünleri giriniz");
                    String itemsToRemove = scanner.nextLine();
                    removeItems(itemsToRemove);
                    break;
                default:
                    System.out.println("Hatalı seçim. 0, 1, 2 dışında seçim alanı yoktur");
            }
            printSorted();
        }
    }
}
