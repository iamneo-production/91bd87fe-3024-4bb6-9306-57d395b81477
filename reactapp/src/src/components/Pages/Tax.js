import React from 'react';
import { Container, Row, Col, Card, Form, Button, Table } from 'react-bootstrap';
import Slidebar from '../NavBar/Slidebar';
import AppNavbar from '../NavBar/Navbar';
import Footer from '../NavBar/footer';

const TaxPreparation = () => {
  const handleSubmit = (e) => {
    e.preventDefault();
  };

  return (
    <Container>
      <Slidebar />
      <AppNavbar />
      <Row className="justify-content-center mt-5" style={{ marginLeft: '20px' }}>
        <Col md={9}>
          <Card style={{ height: '340px' }}>
            <Card.Header as="h5">Tax Form</Card.Header>
            <Card.Body>
              <Form onSubmit={handleSubmit}>
                {/* Add tax form fields and inputs */}
                {/* Example: */}
                <Form.Group controlId="income">
                  <Form.Label>Income</Form.Label>
                  <Form.Control type="number" name="income" />
                </Form.Group>
                <Form.Group controlId="deductions">
                  <Form.Label>Deductions</Form.Label>
                  <Form.Control type="number" name="deductions" />
                </Form.Group>
                <Form.Group controlId="credits">
                  <Form.Label>Tax Credits</Form.Label>
                  <Form.Control type="number" name="credits" />
                </Form.Group>
                <br />
                <Button variant="primary" type="submit">
                  Calculate Tax
                </Button>
              </Form>
            </Card.Body>
          </Card>
        </Col>
        <Col md={3}>
          <Card style={{ height: '340px' }}>
            <Card.Header as="h5">Tax Reports</Card.Header>
            <Card.Body>
              {/* Display tax reports generated */}
              {/* Example: */}
              <p>Income Tax: $1000</p>
              <p>Property Tax: $500</p>
              <p>Sales Tax: $1000</p>
              <p>Wealth Tax: $1000</p>
              <p>Gift Tax: $1000</p>
              <p>Custom Tax: $1000</p>
              <p>Service Tax: $1000</p>

              {/* Add more tax reports as needed */}
            </Card.Body>
          </Card>
        </Col>
      </Row>
      <Row className="justify-content-center mt-5">
        <Col md={8}>
          <Card>
            <Card.Header as="h5">Tax Records</Card.Header>
            <Card.Body style={{ maxHeight: '300px', overflowY: 'auto' }}>
              <Table striped bordered>
                <thead>
                  <tr>
                    <th>S.No</th>
                    <th>Year</th>
                    <th>Tax ID</th>
                    <th>Receipt No</th>
                    <th>Income</th>
                    <th>Tax Paid</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>1</td>
                    <td>2023</td>
                    <td>TAX123</td>
                    <td>12345</td>
                    <td>$50,000</td>
                    <td>$5,000</td>
                  </tr>
                  <tr>
                    <td>2</td>
                    <td>2022</td>
                    <td>TAX456</td>
                    <td>67890</td>
                    <td>$60,000</td>
                    <td>$6,500</td>
                  </tr>
                  <tr>
                    <td>3</td>
                    <td>2021</td>
                    <td>TAX789</td>
                    <td>24680</td>
                    <td>$70,000</td>
                    <td>$7,200</td>
                  </tr>
                  <tr>
                    <td>4</td>
                    <td>2020</td>
                    <td>TAX012</td>
                    <td>13579</td>
                    <td>$55,000</td>
                    <td>$5,500</td>
                  </tr>
                  <tr>
                    <td>5</td>
                    <td>2019</td>
                    <td>TAX345</td>
                    <td>97531</td>
                    <td>$45,000</td>
                    <td>$4,500</td>
                  </tr>
                </tbody>
              </Table>
            </Card.Body>
          </Card>
        </Col>
      </Row>
      <Footer />
    </Container>
  );
};

export default TaxPreparation;
