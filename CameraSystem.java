package org.ganeshjadhav.question1;


import java.util.List;
import java.util.Map;
import java.util.Queue;
interface Camera{

    Response takeImage(Request request);

}

class HighPriorityCamera implements  Camera{


    // it will instantly take picture and send response;
    // only one request could be served at a time so added  synchronization
    @Override
    synchronized public Response takeImage(Request request) {
        return new Response();
    }
}

class MediumPriorityCamera implements  Camera{

    Queue<Request> requests;
    // it will instantly take picture and send response;
    // only one request could be served at a time so added  synchronization
    @Override
    synchronized public Response takeImage(Request request) {
        return new Response();
    }
}

interface CameraStrategy{
    Camera findCamera(Request request);
}

class RandomCameraStrategy implements CameraStrategy{
    Map<PRIORITY, Camera> cameraMap;

    @Override
    public Camera findCamera(Request request) {
        return null;
    }
}


interface   RequestRepository{
    // when ever request will come we can save it in db
    int save(Request request);
}

class TaskService{
    CameraStrategy cameraStrategy;
    RequestRepository  requestRepository;
    Response create(Request request){
        int rId = requestRepository.save(request);
        Camera camera = cameraStrategy.findCamera(request);
        return null;
    }
}
class CameraSystem{
    TaskService taskService;
    public  Response take(Request request){
        //
        taskService.create();
    }

    public Response get(Client client, int requestId){
        return  null;
    }
}

class  Request{
    int id;
    Client client;
    PRIORITY priority;
    enum status{
        SENT, FAILED, PROCESSED
    };



}

class Response{
    int status;
    String message;
    Image image;
    String errorMessage;
    Response makeResponse(){
        // will have builder here;
        return  new Response();
    }
}

class  Client{
    int id;
    int name;
    List<Image> images;
}

enum PRIORITY{
    HIGH,MEDIUM,LOW
}
class  Image {
    int id;
    int url;
}