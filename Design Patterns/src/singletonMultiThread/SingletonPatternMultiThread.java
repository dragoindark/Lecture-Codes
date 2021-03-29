package singletonMultiThread;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//
//The classes and/or objects participating in this pattern are:
//1. Singleton   (LoadBalancer)
//		Defines an Instance operation that lets clients access its unique
//		instance. Instance is a class operation. Responsible for
//		creating and maintaining its own unique instance

//This is the "Singleton" class.

class LoadBalancer {
	// Thread Safe Load Balancer without Double Locking
	public static LoadBalancer GetLoadBalancer() {
		if (instance == null) {
		lock.lock();
		System.out.println(
				Thread.currentThread().getName() + 
				" acquired lock");
		try {
			if (instance == null)
				instance = new LoadBalancer();
		} finally {
			lock.unlock();
			System.out.println(
					Thread.currentThread().getName() +  
					" released lock");
		}
		}
		return instance;
	}
 // Simple load balancer
	public String getServer() {	
		Random rand = new Random();
		return servers.get(rand.nextInt(servers.size())); 
	}

	// Constructor (private).
	private LoadBalancer() {
	      // List of available servers
	      servers.add("ServerI");
	      servers.add("ServerII");
	      servers.add("ServerIII");
	      servers.add("ServerIV");
	      servers.add("ServerV");
	}

	private static LoadBalancer instance = null;
	private ArrayList<String> servers = new ArrayList<String>();
	private static final Lock lock = new ReentrantLock(); 
} // class LoadBalancer

class MyRunnable implements Runnable{
    public void run() {
        System.out.println("Thread started::"+Thread.currentThread().getName());
        LoadBalancer lb = LoadBalancer.GetLoadBalancer();
        System.out.println("load balancer : <" + lb + ">");
        System.out.println("Thread ended::"+Thread.currentThread().getName());
    }  
}

public class SingletonPatternMultiThread {
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new MyRunnable(), "t1");
        Thread t2 = new Thread(new MyRunnable(), "t2");
        Thread t3 = new Thread(new MyRunnable(), "t3");
        
        t1.start();
        t2.start();
        t3.start();
	}
}
