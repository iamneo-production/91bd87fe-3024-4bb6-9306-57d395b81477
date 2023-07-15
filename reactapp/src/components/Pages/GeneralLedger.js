import AppNavbar from '../NavBar/Navbar';
import Slidebar from '../NavBar/Slidebar';
import { Row, Col, Card } from 'react-bootstrap';
import { ProgressBar } from 'react-bootstrap';
import React, { Component } from 'react';
import './css/GeneralLedger.css'; // Import the CSS file
import SalesExpenseGraph from '../icons/chart';
import InventoryManagementChart from '../icons/piechart';
import Footer from '../NavBar/footer';

function GeneralLedger() {
  return (
    <div>
      <AppNavbar />
      <div className="container-fluid">
        <div className="row">
          <div style={{ width: '95px' }}>
            <Slidebar />
          </div>
          <div className="col-md-11">
          <Row>
      <Col sm={4}>
        <Card>
          <Card.Body>
            <div>TOTAL RECIVABLES</div>
            <hr />
            <div>TOTAL UNPAID INVOICE</div>
            <div><ProgressBar>
              <ProgressBar variant="success " now={75} key={1} />
              <ProgressBar variant="danger" now={25} key={2} />
            </ProgressBar>
            </div>
            <hr />
            <div>
            <Row>
              <Col>
                <Card className="border-0">
                  <div>CURRENT</div>
                  <div>$75</div>
                </Card>
              </Col>
              <Col>
                <Card className="border-0">
                  <div>OVERDUE</div>
                  <div>$25</div>
                </Card>
              </Col>
              
            </Row>
            </div>
          </Card.Body>
        </Card>
      </Col>
      
      <Col sm={4}>
        <Card>
          <Card.Body>
            <div>TOTAL PAYABLES</div>
            <hr />
            <div>TOTAL UNPAID BILLS</div>
            <div><ProgressBar>
              <ProgressBar variant="danger " now={75} key={1} />
              <ProgressBar variant="success" now={25} key={2} />
            </ProgressBar>
            </div>
            <hr />
            <div>
            <Row>
              <Col>
                <Card className="border-0">
                  <div>CURRENT</div>
                  <div>$75</div>
                </Card>
              </Col>
              <Col>
                <Card className="border-0">
                  <div>OVERDUE</div>
                  <div>$25</div>
                </Card>
              </Col>
              
            </Row>
            </div> 
          </Card.Body>
        </Card>
      </Col>
      
      <Col sm={4}>
        <Card>
          <Card.Body>
            <div>GST PAYABLE</div>
            <hr />
            <div>DUEABLE TAX</div>
            <div><ProgressBar>
              <ProgressBar variant="info " now={75} key={1} />
              <ProgressBar variant="warning" now={25} key={2} />
            </ProgressBar>
            </div>
            <hr />
            <div>
            <Row>
              <Col>
                <Card className="border-0">
                  <div>CURRENT</div>
                  <div>$75</div>
                </Card>
              </Col>
              <Col>
                <Card className="border-0">
                  <div>OVERDUE</div>
                  <div>$25</div>
                </Card>
              </Col>
              
            </Row>
            </div>
          </Card.Body>
        </Card>
      </Col>
    </Row>
    <br />
    <Row>
    <Col sm={8}>
        <Card style={{ height: '450px' }}>
          <Card.Body >
            <div className="row">
          <div className="col">
            <div className="left-column">
              <div>SALES AND EXPENSES</div>
              <SalesExpenseGraph />
            </div>
          </div>
          <div className="col">
            <div className="vertical-line"></div>
          </div>
          <div className="col">
            <div className="right-column">
              <Card className="border-0">
                <Card.Body>
                  <h6 className='text-success'>Total Income</h6>
                  <h3>$123456</h3>
                </Card.Body>
              </Card>
              <Card className="border-0">
                <Card.Body>
                  <h6 className='text-danger'>Total Expenses</h6>
                  <h3>$123456</h3>
                </Card.Body>
              </Card>
              <Card className="border-0">
                <Card.Body>
                <h6 className='text-warning'>Profit</h6>
                  <h3>$123456</h3>
                </Card.Body>
              </Card>
            </div>
          </div>
        </div>
          </Card.Body>
        </Card>
      </Col>
      <Col sm={4}>
        <Card style={{ height: '450px' }}>
          <Card.Body>
            <div>INVENTORY STOCKS</div><br /><br />
            <InventoryManagementChart />
            <br /><br />
          </Card.Body>
        </Card>
      </Col>
    </Row>
          </div>
        </div>
      </div>
      <Footer />
    </div>
  );
}

export default GeneralLedger;