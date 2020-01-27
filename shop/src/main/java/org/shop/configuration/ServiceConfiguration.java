package org.shop.configuration;

import org.shop.api.*;
import org.shop.api.impl.*;
import org.shop.repository.ItemRepository;
import org.shop.repository.ProductRepository;
import org.shop.repository.ProposalRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

    @Bean
    public ItemService itemService(ItemRepository itemRepository){
        return new ItemServiceImpl(itemRepository);
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl();
    }

    @Bean("productService")
    public ProductService productService(ProductRepository productRepository) {
        return new ProductServiceImpl(productRepository);
    }

    @Bean("proposalService")
    public ProposalService proposalService(ProposalRepository proposalRepository) {
        return new ProposalServiceImpl(proposalRepository);
    }

    @Bean
    public SellerService sellerService(){
        return new SellerServiceImpl();
    }

    @Bean
    public UserService userService(){
        return new UserServiceImpl();
    }
}
