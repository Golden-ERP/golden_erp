package com.goldenconsultingci.erp.juridique.composite;

public class CompositeClient {
    public static  void main(String... args) {
        Task task =  new TaskSimple();
        task =  new TaskList();
    }
}
