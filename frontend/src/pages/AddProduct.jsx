import { useState } from "react";
import { useNavigate } from "react-router-dom";
import API from "../services/api";

function AddProduct() {
  const navigate = useNavigate();

  const [product, setProduct] = useState({
    name: "",
    price: "",
    quantity: "",
    imageUrl: ""
  });

  const handleChange = (e) => {
    setProduct({...product,[e.target.name]: e.target.value});
  };

  const saveProduct = (e) => {
    e.preventDefault();
    API.post("/products", product)
      .then(() => {
        alert("Product Added");
        navigate("/admin-dashboard");
      });
  };

  return (
    <div className="container mt-4">
      <h2>Add Product</h2>

      <input className="form-control mb-2" name="name" placeholder="Name" onChange={handleChange}/>
      <input className="form-control mb-2" name="price" placeholder="Price" onChange={handleChange}/>
      <input className="form-control mb-2" name="quantity" placeholder="Quantity" onChange={handleChange}/>
      <input className="form-control mb-2" name="imageUrl" placeholder="Image URL" onChange={handleChange}/>

      <button className="btn btn-success" onClick={saveProduct}>Save</button>
    </div>
  );
}

export default AddProduct;