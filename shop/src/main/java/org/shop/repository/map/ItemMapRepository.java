package org.shop.repository.map;

import java.util.List;
import java.util.function.Predicate;

import org.shop.data.Item;
import org.shop.repository.ItemRepository;

public class ItemMapRepository extends AbstractMapRepository<Item> implements ItemRepository {

    /* (non-Javadoc)
     * @see org.shop.repository.ItemRepository#createItem(org.shop.data.Item)
     */
    @Override
    public Long createItem(Item item) {
        return create(item);
    }

    /* (non-Javadoc)
     * @see org.shop.repository.ItemRepository#deleteItem(java.lang.Long)
     */
    @Override
    public void deleteItem(Long itemId) {
        deleteItem(itemId);
    }

    /* (non-Javadoc)
     * @see org.shop.repository.ItemRepository#getItemsByOrderId(java.lang.Long)
     */
    @Override
    public List<Item> getItemsByOrderId(Long orderId) {
        return select(new ItemByOrderPredicate(orderId));
    }
    
    private static class ItemByOrderPredicate implements Predicate<Item> {
        
        private Long orderId;
        
        private ItemByOrderPredicate(Long orderId) {
            super();
            this.orderId = orderId;
        }

        @Override
        public boolean test(Item input) {
            if (input != null) {
                return orderId.equals(input.getOrder().getId());
            }
            return false;
        }
    }
}
