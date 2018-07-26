import React from 'react';
import { connect } from 'dva';
import ProductList from '../components/ProductList';

const Products = ({ dispatch, aaa }) => {
    function handleDelete(id) {
        // dispatch时一个函数方法，用来讲 action 发送到 state
        // dispatch来源：被 connect 的 Component自动在 props 中拥有 dispatch 方法
        dispatch({
            type: 'aaa/delete',
            payload: id,
        });
    }
    return (
        <div>
            <h2>List of Products</h2>
            <ProductList onDelete={handleDelete} products={aaa} />
        </div>
    );
};

/* function mapStateToProp(state) {
    return { products: state.products }
} */

// export default Products;
export default connect(
    // 相当于调用mapStateToProp,建立 state 到 props 的映射关系
    ({ aaa }) => ({ aaa, })
)(Products); 