import React, { useState } from 'react';
import { Container, Row, Col, Card, Form, Button, ListGroup } from 'react-bootstrap';
import AppNavbar from '../NavBar/Navbar';
import Slidebar from '../NavBar/Slidebar';
import Footer from '../NavBar/footer';

const ExpenseTracker = () => {
  const [expenses, setExpenses] = useState([
    {
      type: 'expense',
      description: 'Services',
      amount: '50',
      category: 'Office Expenses',
      receipt: null,
    },
    {
      type: 'expense',
      description: 'Loan',
      amount: '100',
      category: 'Business Loan',
      receipt: null,
    },
    {
      type: 'expense',
      description: 'Goods',
      amount: '200',
      category: 'Goods Expenses',
      receipt: null,
    },
    {
      type: 'expense',
      description: 'Marketing',
      amount: '150',
      category: 'Marketing Expenses',
      receipt: null,
    },
    {
      type: 'expense',
      description: 'Rent',
      amount: '500',
      category: 'Office Rent',
      receipt: null,
    },
  ]);

  const [sales, setSales] = useState([
    {
      type: 'sale',
      description: 'Product A',
      amount: '500',
      category: 'Product Sales',
      receipt: null,
    },
    {
      type: 'sale',
      description: 'Service B',
      amount: '1000',
      category: 'Service Sales',
      receipt: null,
    },
    {
      type: 'sale',
      description: 'Product C',
      amount: '800',
      category: 'Product Sales',
      receipt: null,
    },
    {
      type: 'sale',
      description: 'Service D',
      amount: '1200',
      category: 'Service Sales',
      receipt: null,
    },
    {
      type: 'sale',
      description: 'Product E',
      amount: '700',
      category: 'Product Sales',
      receipt: null,
    },
  ]);

  const [newTransaction, setNewTransaction] = useState({
    type: '',
    description: '',
    amount: '',
    category: '',
    receipt: null,
  });

  const handleInputChange = (e) => {
    setNewTransaction({
      ...newTransaction,
      [e.target.name]: e.target.value,
    });
  };

  const handleFileChange = (e) => {
    setNewTransaction({
      ...newTransaction,
      receipt: e.target.files[0],
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (newTransaction.type === 'expense') {
      setExpenses([...expenses, newTransaction]);
    } else if (newTransaction.type === 'sale') {
      setSales([...sales, newTransaction]);
    }
    setNewTransaction({
      type: '',
      description: '',
      amount: '',
      category: '',
      receipt: null,
    });
  };

  return (
    <Container>
      <Container fluid>
        <Row>
          <Col md={1}><Slidebar /></Col>
          <AppNavbar />
          </Row>
          </Container>
      <Row className="justify-content-center mt-5">
        <Col md={6}>
          <Card>
            <Card.Header as="h5">Expenses and Sales Bills</Card.Header>
            <Card.Body>
              <Form onSubmit={handleSubmit}>
                <Form.Group controlId="type">
                  <Form.Label>Type</Form.Label>
                  <Form.Control
                    as="select"
                    name="type"
                    value={newTransaction.type}
                    onChange={handleInputChange}
                  >
                    <option value="">Select Type</option>
                    <option value="expense">Expense</option>
                    <option value="sale">Sale</option>
                  </Form.Control>
                </Form.Group>
                <Form.Group controlId="description">
                  <Form.Label>Description</Form.Label>
                  <Form.Control
                    type="text"
                    name="description"
                    value={newTransaction.description}
                    onChange={handleInputChange}
                  />
                </Form.Group>
                <Form.Group controlId="amount">
                  <Form.Label>Amount</Form.Label>
                  <Form.Control
                    type="number"
                    name="amount"
                    value={newTransaction.amount}
                    onChange={handleInputChange}
                  />
                </Form.Group>
                <Form.Group controlId="category">
                  <Form.Label>Category</Form.Label>
                  <Form.Control
                    as="select"
                    name="category"
                    value={newTransaction.category}
                    onChange={handleInputChange}
                  >
                    <option value="">Select Category</option>
                    <option value="Goods">Goods</option>
                    <option value="Services">Services</option>
                    <option value="Loan">Loan</option>
                  </Form.Control>
                </Form.Group>
                <Form.Group controlId="receipt">
                  <Form.Label>Receipt</Form.Label>
                  <Form.Control type="file" name="receipt" onChange={handleFileChange} />
                </Form.Group>
                <Button variant="primary" type="submit">
                  Add Transaction
                </Button>
              </Form>
            </Card.Body>
          </Card>
        </Col>
      </Row>
      <Row className="justify-content-center mt-4" style={{height:'200px'}}>
        <Col md={6}>
          <Card>
            <Card.Header as="h5">Expense List</Card.Header>
            <Card.Body style={{ maxHeight: '300px', overflowY: 'auto' }}>
              <ListGroup>
                {expenses.map((expense, index) => (
                  <ListGroup.Item key={index}>
                    <strong>Description:</strong> {expense.description}
                    <br />
                    <strong>Amount:</strong> ${expense.amount}
                    <br />
                    <strong>Category:</strong> {expense.category}
                    {expense.receipt && (
                      <a href={URL.createObjectURL(expense.receipt)} target="_blank" rel="noreferrer">
                        View Receipt
                      </a>
                    )}
                  </ListGroup.Item>
                ))}
              </ListGroup>
            </Card.Body>
          </Card>
        </Col>
        <Col md={6}>
          <Card>
            <Card.Header as="h5">Sales List</Card.Header>
            <Card.Body style={{ maxHeight: '300px', overflowY: 'auto' }}>
              <ListGroup>
                {sales.map((sale, index) => (
                  <ListGroup.Item key={index}>
                    <strong>Description:</strong> {sale.description}
                    <br />
                    <strong>Amount:</strong> ${sale.amount}
                    <br />
                    <strong>Category:</strong> {sale.category}
                    {sale.receipt && (
                      <a href={URL.createObjectURL(sale.receipt)} target="_blank" rel="noreferrer">
                        View Receipt
                      </a>
                    )}
                  </ListGroup.Item>
                ))}
              </ListGroup>
            </Card.Body>
          </Card>
        </Col>
      </Row>
    </Container>
  );
};

export default ExpenseTracker;
