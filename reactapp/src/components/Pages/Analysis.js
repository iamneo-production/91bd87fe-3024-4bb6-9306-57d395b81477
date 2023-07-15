import React from 'react';
import ApexCharts from 'react-apexcharts';
import AppNavbar from '../NavBar/Navbar';
import Slidebar from '../NavBar/Slidebar';
import { Container, Row, Col } from 'react-bootstrap';
import Footer from '../NavBar/footer';

const ProfitLossStatement = () => {
  const data = {
    revenue: [5000, 6000, 7000, 8000, 9000, 10000],
    expenses: [2000, 2500, 3000, 3500, 4000, 4500],
    months: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun'],
  };

  const statementOptions = {
    chart: {
      type: 'bar',
    },
    series: [
      {
        name: 'Revenue',
        data: data.revenue,
      },
      {
        name: 'Expenses',
        data: data.expenses,
      },
    ],
    xaxis: {
      categories: data.months,
    },
  };

  const candlestickData = [
    {
      x: new Date('2023-01-01').getTime(),
      y: [5000, 8000, 4000, 9000],
    },
    {
      x: new Date('2023-02-01').getTime(),
      y: [6000, 8500, 3500, 9500],
    },
    {
      x: new Date('2023-03-01').getTime(),
      y: [7000, 9000, 5000, 10000],
    },
  ];

  const candlestickOptions = {
    chart: {
      type: 'candlestick',
      toolbar: {
        show: false,
      },
    },
    series: [
      {
        data: candlestickData,
      },
    ],
    xaxis: {
      type: 'datetime',
    },
  };

  return (
    <div>
      <Container fluid>
        <Row>
          <Col md={1}><Slidebar /></Col>
            <AppNavbar />
          </Row>
      </Container>
      <div style={{marginLeft:'80px'}}>
      <div>
        <h2>Profit and Loss Statement</h2>
        <ApexCharts options={statementOptions} series={statementOptions.series} type="bar" height={290} width={1300} />
      </div>
      <div>
        <h2>Candlestick Chart</h2>
        <ApexCharts
          options={candlestickOptions}
          series={candlestickOptions.series}
          type="candlestick"
          height={290}
          width={1300}
        />
      </div>
    </div>
    <Footer />
    </div>
  );
};

export default ProfitLossStatement;
