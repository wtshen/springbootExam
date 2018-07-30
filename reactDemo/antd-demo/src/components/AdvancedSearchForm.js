import { Form, Row, Col, Input, Button, Icon } from 'antd';
import '../App.css';
import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import { mapStateToProps } from '../actions/mapStateToProps';
import { mapDispatchToProps } from '../actions/mapDispatchToProps';
import { connect } from 'react-redux';

const FormItem = Form.Item;

const formItemLayout = {
    labelCol: { span: 5 },
    wrapperCol: { span: 15 }
};
console.log(mapDispatchToProps)

class AdvancedSearchForm extends React.Component {
    state = {
        expand: false,
    }

    handleSearch = (e) => {
        e.preventDefault();
        this.props.form.validateFields((err, values) => {
            console.log('Received values of form: ', values);
        });
        this.props.bookSearch({})
    }

    handleReset = () => {
        this.props.form.resetFields();
    }

    toggle = () => {
        const { expand } = this.state;
        this.setState({ expand: !expand });
    }

    render() {
        console.log(this.props);
        const { getFieldDecorator, getFeildsValue } = this.props.form;
        const { record } = this.props;

        return (
            <Form className="ant-advanced-search-form" onSubmit={(e) => { this.handleSearch(e) }}>
                <Row gutter={24}>
                    <Col span={8}>
                        <FormItem label="编号" {...formItemLayout} >
                            {getFieldDecorator('id', {
                                rules: [{
                                    required: true, message: '请输入书籍编号！'
                                }],
                                initialValue: record ? record.id : ""
                            })(
                                <Input placeholder="请输入书籍编号" />
                            )}
                        </FormItem>
                    </Col>
                    <Col span={8}>
                        <FormItem label="名称" {...formItemLayout}>
                            {getFieldDecorator('name', {
                                rules: [{
                                    required: true, message: '请输入书籍名称!'
                                }],
                                initialValue: record ? record.name : ""
                            })(
                                <Input placeholder="请输入书籍名称" />
                            )}
                        </FormItem>
                    </Col>
                </Row>
                <Row gutter={24}>
                    <Col span={8}>
                        <FormItem label="价格"  {...formItemLayout}>
                            {getFieldDecorator('price', {
                                rules: [{
                                    required: true, message: '请输入价格!'
                                }, {
                                    pattern: /(^[1-9](\d+)?(\.\d{1,2})?$)|(^(0){1}$)|(^\d\.\d{1,2}?$)/, message: '请输入正确的金额'
                                }],
                                initialValue: record ? record.price : ""
                            })(
                                <Input placeholder="请输入价格" />
                            )}
                        </FormItem>
                    </Col>
                    <Col span={8}>
                        <FormItem label="借阅者编号"  {...formItemLayout}>
                            {getFieldDecorator('owner_id', {
                                rules: [{
                                    required: true, message: '请输入借阅者编号!'
                                }, {
                                    pattern: /^(\d{5})$/, message: '请输入5位数字'
                                }],
                                initialValue: record ? record.owner_id : ""
                            })(
                                <Input placeholder="请输入借阅者编号" />
                            )}
                        </FormItem>
                    </Col>
                </Row>
                <FormItem wrapperCol={{ span: 10, offset: 10 }}>
                    <Button type="primary" htmlType="submit">
                        确定
                    </Button>
                    <Button onClick={this.handleReset}>
                        清除
                    </Button>
                </FormItem>
            </Form>
        );
    }
}
export default connect(mapStateToProps, mapDispatchToProps)(AdvancedSearchForm);
//const WrappedAdvancedSearchForm = Form.create()(AdvancedSearchForm);
//export default WrappedAdvancedSearchForm