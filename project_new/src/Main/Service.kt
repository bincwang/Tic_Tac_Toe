package Main

//Service connects with the interface engine, when Controller calls Service, it will call engine remotely
//That's the benefit of the interface, which makes code simple.

//By using OO module. The service is using what we implemented on Engine.
class Service:Engine{
    override var win = false
}