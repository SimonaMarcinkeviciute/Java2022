import {useParams} from "react-router-dom";

export default () => {

    // galima pasiiimti per hooks, issitraukti parapetra pagal key. sis hooks ateina ir route componento
    const {productId} = useParams();

    return (
        <div>Product id: {productId}</div>
    );
}