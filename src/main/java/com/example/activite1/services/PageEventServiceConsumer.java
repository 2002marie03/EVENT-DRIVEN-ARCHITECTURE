package com.example.activite1.services;

import com.example.activite1.entities.PageEvent;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.Grouped;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.TimeWindows;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Date;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Service
public class PageEventServiceConsumer {
    @Bean
    public Consumer<PageEvent> pageEventConsumer(){
        return (input)->{
            System.out.println("**************************");
            System.out.println(input.toString());
            System.out.println("*****************");
        };
    }

    @Bean
    public Supplier<PageEvent> pageEventSupplier(){
        return () -> new PageEvent(Math.random()>0.5?"p1":"p2"
                ,Math.random()>0.5?"user1":"user2"
                ,new Date(),new Random().nextInt(9000));
    }

    @Bean
    public Function<PageEvent,PageEvent> pageEventFunction(){
        return (input)->{
            input.setName("h1");
            input.setUser("us1");
            return input;
        };
    }
    @Bean
    public  Function<KStream<String,PageEvent>,KStream<String,Long>> kStreamFunction(){     //notre fonction va recevoir un data record qui contient un key (qu'il est un string ) et une valeur dans notre cas notre messagee est un pageevent et retourn un key aussi mais avec un resultat conveneble au situation dans notre application on veut savoir le nobre de vissite de notre site web
        return (input)->{
            return input
                    .filter((k,v)->v.getDuration()>100)
                    .map((k,v)-> new KeyValue<>(v.getName(),0L))
                    .groupBy((k,v)->k, Grouped.with(Serdes.String(),Serdes.Long()))
                    .windowedBy(TimeWindows.of(Duration.ofSeconds(5)))
                    .count(Materialized.as("page-count"))
                    .toStream()
                    .map((k,v)->new KeyValue<>("=>"+k.window().startTime()+k.window().endTime()+k.key(),v));

        };
    }
}
