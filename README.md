Android-Messenger-Service
=========================

Example of an activity communicating to a service through Messenger.

If you need your service to communicate with remote processes, then you can use a Messenger to provide the interface
for your service. 

Here's a summary of how to use a Messenger:                                                                               
  1) The service implements a Handler that receives a callback for each call from a client.
  2) The Handler is used to create a Messenger object (which is a reference to the Handler).
  3) The Messenger creates an IBinder that the service returns to clients from onBind().
  4) Clients use the IBinder to instantiate the Messenger (that references the service's Handler),
     which the client uses to send Message objects to the service.
  5) The service receives each Message in its Handler—specifically, in the handleMessage() method.
  
  See https://developer.android.com/guide/components/bound-services.html#Messenger for more info.
