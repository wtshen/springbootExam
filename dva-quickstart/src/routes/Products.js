import React from 'react';
import { connect } from 'dva';
import ProductList from '../components/ProductList';

const Products = ({ dispatch, products }) => {
    function handleDelete(id) {
        dispatch({
            type: 'products/delete',
            payload: id,
        });
    }
    return (
        <div>
            <h2>List of Products</h2>
            <ProductList onDelete={handleDelete} products={products} />
        </div>
    );
};

/* function mapStateToProp(state) {
    return { products: state.products }
} */

// export default Products;
export default connect(
    // 相当于调用mapStateToProp,建立 state 到 props 的映射关系
    ({ products }) => ({ products, })
)(Products); 