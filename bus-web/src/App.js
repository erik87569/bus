import './App.css';
import React, { useEffect, useMemo, useState } from "react";
import { useTable } from 'react-table';
import axios from 'axios';

function App() {

  const [data, setData] = useState([]);

  const getLines = (state) => {
    axios.get(`http://localhost:9090/bus-lines`)
      .then(res => {
        setData(res.data);
      })
  };

  useEffect(() => {
    getLines();
  }, []);

  const columns = useMemo(
    () => [
      {
        Header: 'Bus lines',
        columns: [
          {
            Header: 'Line',
            accessor: 'lineNumber',
          },
          {
            Header: 'Stops',
            accessor: 'numberOfStops',
          },
        ],
      },
    ],
    []
  )


  const {
    getTableProps,
    getTableBodyProps,
    headerGroups,
    rows,
    prepareRow,
  } = useTable({
    columns: columns,
    data: data,
  });

  return (
    <div className="App">
      <header className="App-header">
        <table {...getTableProps()}>
          <thead>
            {headerGroups.map((headerGroup) => (
              <tr {...headerGroup.getHeaderGroupProps()}>
                {headerGroup.headers.map((column) => (
                  <th {...column.getHeaderProps()}>
                    {column.render("Header")}
                  </th>
                ))}
              </tr>
            ))}
          </thead>
          <tbody {...getTableBodyProps()}>
            {rows.map((row) => {
              prepareRow(row);
              return (
                <tr {...row.getRowProps()}>
                  {row.cells.map((cell) => {
                    return (
                      <td {...cell.getCellProps()}>{cell.render("Cell")}</td>
                    );
                  })}
                </tr>
              );
            })}
          </tbody>
        </table>
      </header>
    </div>
  );
}

export default App;
