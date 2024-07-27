# Design Camera System
### 
1. **Tables**
    1. Image table
        * id (primary key)
        * url
        
    2. request table
        * client_id (FK client table)
        * image_id (FK image table)
        * priority
        * status
    3. client table
        * id PK
        * name

## Actors considered
1. client 
2. Camera system
3. Task service to find appropriate camera for the given priority
4. Camera Strategy will have the map of cameras it will return the appropriate camera


## flow 
1. Client will make request to capture and image.
2. Based on priority system will decide the course of action.
3. If priority is high then the request would be processed immediately and response will be sent.
4. If priority is low/medium then it can be put in the queue to process it later.
5. If any error occur then it will be sent to the client.
