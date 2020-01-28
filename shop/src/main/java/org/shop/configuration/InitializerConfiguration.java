package org.shop.configuration;

import org.shop.*;
import org.shop.api.ProductService;
import org.shop.api.UserService;
import org.shop.data.Seller;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Configuration
public class InitializerConfiguration {

    @Bean(initMethod="initData")
    public DataInitializer dataInitializer(){
        return new DataInitializer();
    }

    @Bean
    public ProductInitializer productInitializer(ProductService productService){
        return new ProductInitializer(productService);
    }

    @Bean("proposalInitializer")
    public ProposalInitializer proposalInitializer(){
        return new ProposalInitializer();
    }

    @Bean
    public SellerInitializer sellerInitializer(){
        return new SellerInitializer();
    }

    @Bean
    public UserInitializer userInitializer(UserService userService){
        return new UserInitializer(userService);
    }

    @Bean
    public Map<Long, String> sellerNames(){
        Map<Long, String> map = new HashMap<>();
        map.put(1L, "amazon");
        map.put(2L, "samsung");
        return map;
    }

}
