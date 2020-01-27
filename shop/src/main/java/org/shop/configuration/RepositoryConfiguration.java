package org.shop.configuration;

import org.shop.repository.*;
import org.shop.repository.factory.UserRepositoryFactory;
import org.shop.repository.map.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.Objects;

@Configuration
@PropertySource("classpath:repository.properties")
public class RepositoryConfiguration {

    @Autowired
    private UserRepositoryFactory userRepositoryFactory;

    @Autowired
    private Environment environment;

    @Bean
    public ItemRepository itemRepository(){
        return new ItemMapRepository();
    }

    @Bean
    public OrderRepository orderRepository(){
        OrderMapRepository orderRepository = new OrderMapRepository();
        orderRepository.setSequence(
                Long.parseLong(
                        Objects.requireNonNull(
                                environment.getProperty("repository.initialSequence")
                        )
                )
        );
        return orderRepository;
    }

    @Bean
    public ProductRepository productRepository(){
        return new ProductMapRepository();
    }

    @Bean
    public ProposalRepository proposalRepository(){
        return new ProposalMapRepository();
    }

    @Bean
    public SellerRepository sellerRepository(){
        return new SellerMapRepository();
    }

    @Bean
    public UserRepository userRepository(){
        return userRepositoryFactory.createUserRepository();
    }
}
