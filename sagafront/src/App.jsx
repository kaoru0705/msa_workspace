import { Routes, Route } from "react-router-dom";
import './App.css'
import OrderForm from "./pages/OrderForm.jsx";

function App() {

  return (
    <Routes>
      <Route path="/" element={<OrderForm />} />
    </Routes>
  )
}

export default App
