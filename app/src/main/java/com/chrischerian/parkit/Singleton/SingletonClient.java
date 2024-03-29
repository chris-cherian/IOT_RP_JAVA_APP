package com.chrischerian.parkit.Singleton;

import androidx.lifecycle.MutableLiveData;

import com.chrischerian.parkit.Model.Details;
import com.chrischerian.parkit.Socket.Client;

public class SingletonClient {

    private static SingletonClient instance = null;
    private MutableLiveData<Integer> vacant = new MutableLiveData<>();
    private MutableLiveData<String> license_num = new MutableLiveData<>();
    private MutableLiveData<String> license_num_status = new MutableLiveData<>();
    private MutableLiveData<Boolean> connection_status = new MutableLiveData<>();
    private Details details = new Details();

    public Details getDetails(){
        return details;
    }

    public void setDetails(Details details){
        this.details = details;
    }

    public MutableLiveData<Boolean> getConnectionStatus () {
        return connection_status;
    }


    public MutableLiveData<Integer> getVacant () {
        return vacant;
    }

    public MutableLiveData<String> getLicense_num() {
        return license_num;
    }

    public MutableLiveData<String> getLicense_num_status() {
        return license_num_status;
    }

    public static SingletonClient getInstance(){
        if (instance == null){
            instance = new SingletonClient();
        }
        return instance;
    }

    private Client client = new Client("192.168.42.247",5000);

    public  Client getClient(){
        return client;
    }

    private SingletonClient(){

        Thread th = new Thread(client);
        th.start();
        connection_status.setValue(false);

    }

}
