import React from 'react';
import { Container, Row, Col, Table, Button, Card } from 'react-bootstrap';
import AppNavbar from '../NavBar/Navbar';
import Slidebar from '../NavBar/Slidebar';
import Footer from '../NavBar/footer';

const InventoryManagementPage = () => {
  const [stockLevels, setStockLevels] = React.useState([]);
  const [purchaseOrders, setPurchaseOrders] = React.useState([]);
  const [salesOrders, setSalesOrders] = React.useState([]);
  const [inventoryReports, setInventoryReports] = React.useState([]);

  const addPurchaseOrder = (order) => {
    setPurchaseOrders([...purchaseOrders, order]);
  };

  const addSalesOrder = (order) => {
    setSalesOrders([...salesOrders, order]);
  };

  const generateInventoryReports = () => {
    const report = 'Sample Report';
    setInventoryReports([...inventoryReports, report]);
  };

  return (
    <div style={{marginLeft:'30px'}}>
      <Container fluid >
        <Row>
          <Col md={1}>
            <Slidebar />
          </Col>
          <Col>
            <AppNavbar />
          </Col>
        </Row>
      </Container>
      <Container>
        <Row>
          <Col>
            <h1>Inventory Management</h1>
          </Col>
        </Row>
        <Row>
          <Col>
            <Card>
              <Card.Body>
                <h2>Stock Levels</h2>
                <Table striped bordered>
                  <thead>
                    <tr>
                      <th>Product</th>
                      <th>Quantity</th>
                    </tr>
                  </thead>
                  <tbody>
                    {stockLevels.map((item, index) => (
                      <tr key={index}>
                        <td>{item.product}</td>
                        <td>{item.quantity}</td>
                      </tr>
                    ))}
                  </tbody>
                </Table>
              </Card.Body>
            </Card>
          </Col>
          </Row>
          <br />
          <Row>
          <Col>
            <Card>
              <Card.Body>
                <h2>Purchase Orders</h2>
                <Table striped bordered>
                  <thead>
                    <tr>
                      <th>Order ID</th>
                      <th>Product</th>
                      <th>Quantity</th>
                    </tr>
                  </thead>
                  <tbody>
                    {purchaseOrders.map((order, index) => (
                      <tr key={index}>
                        <td>{order.id}</td>
                        <td>{order.product}</td>
                        <td>{order.quantity}</td>
                      </tr>
                    ))}
                  </tbody>
                </Table>
                <Button
                  variant="primary"
                  onClick={() =>
                    addPurchaseOrder({ id: 1, product: 'Product A', quantity: 10 })
                  }
                >
                  Add Purchase Order
                </Button>
              </Card.Body>
            </Card>
          </Col>
      
          <Col>
            <Card>
              <Card.Body>
                <h2>Sales Orders</h2>
                <Table striped bordered>
                  <thead>
                    <tr>
                      <th>Order ID</th>
                      <th>Product</th>
                      <th>Quantity</th>
                    </tr>
                  </thead>
                  <tbody>
                    {salesOrders.map((order, index) => (
                      <tr key={index}>
                        <td>{order.id}</td>
                        <td>{order.product}</td>
                        <td>{order.quantity}</td>
                      </tr>
                    ))}
                  </tbody>
                </Table>
                <Button
                  variant="primary"
                  onClick={() =>
                    addSalesOrder({ id: 1, product: 'Product B', quantity: 5 })
                  }
                >
                  Add Sales Order
                </Button>
              </Card.Body>
            </Card>
          </Col>
        </Row>
        <Row>
          
        </Row>
        <br />
        <Row>
          <Col>
            <Card>
              <Card.Body>
                <h2>Inventory Reports</h2>
                <Table striped bordered>
                  <thead>
                    <tr>
                      <th>Report ID</th>
                      <th>Date</th>
                      <th>Details</th>
                    </tr>
                  </thead>
                  <tbody>
                    {inventoryReports.map((report, index) => (
                      <tr key={index}>
                        <td>{report.id}</td>
                        <td>{report.date}</td>
                        <td>{report.details}</td>
                      </tr>
                    ))}
                  </tbody>
                </Table>
                <Button variant="success" onClick={generateInventoryReports}>
              Generate Inventory Reports
            </Button>
              </Card.Body>
            </Card>
          </Col>
        </Row>
      </Container>
      <Footer />
    </div>
  );
};

export default InventoryManagementPage;
