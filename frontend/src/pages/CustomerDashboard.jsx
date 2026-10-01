import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import API from "../services/api";

function CustomerDashboard() {
  const navigate = useNavigate();
  const [products, setProducts] = useState([]);

  useEffect(() => {
    API.get("/products").then((res) => {
      setProducts(res.data);
    });
  }, []);

  const logout = () => {
    localStorage.clear();
    navigate("/login");
  };

  return (
    <div className="container mt-4">
      <h2>Customer Dashboard</h2>
      <button className="btn btn-danger mb-3" onClick={logout}>Logout</button>

      <div className="row">
        {products.map((p) => (
          <div className="col-md-3" key={p.id}>
            <div className="card mb-3">
              <img src={p.imageUrl} className="card-img-top" />
              <div className="card-body">
                <h5>{p.name}</h5>
                <p>₹{p.price}</p>
                <p>Qty: {p.quantity}</p>
                <button className="btn btn-success">Buy</button>
              </div>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}

export default CustomerDashboard;