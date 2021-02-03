package com.bardalez.sample.ribbon.config;

import java.util.List;
import java.util.Random;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

public class MyRule implements IRule {

	private ILoadBalancer lb;
	
	@Override
	public Server choose(Object key) {
        List<Server> servers = lb.getAllServers();
        Random r = new Random();
        int rand = r.nextInt(10);
        if(rand > 7){
            return getServerByPort(servers, 8081);
        }else{
            return getServerByPort(servers, 8080);
        }
	}

	@Override
	public void setLoadBalancer(ILoadBalancer lb) {
		 this.lb = lb;	
	}

	@Override
	public ILoadBalancer getLoadBalancer() {
		  return this.lb;
	}
	
	private Server getServerByPort(List<Server> servers, int port){
        for(Server s : servers){
            if(s.getPort() == port){
                return s;
            }
        }
        return null;
    }

}
