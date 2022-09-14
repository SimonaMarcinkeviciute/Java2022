import SecondHelloWorldComponent from "./SecondHelloWorldComponent";
import ClassHelloWorldComponent from "./ClassHelloWorldComponent";

function HelloWorldComponent(props) {
    // //issitraukiam objekta is propsu, tada nebereikia rasyti prie objekto ar propercio props
    // const {name, surname} = props;
    const {name, surname} = props;
    //sukuriam userio objekta
    const user = {name, surname};
    return (
        <> {/*naudojami properciai*/}
            <div> This is my first component, hello {name} {surname}</div>
            {/*paduodamas objektas*/}
            <SecondHelloWorldComponent user={{name, surname}}/>
            {/*paduodam sukurta useri*/}
            <ClassHelloWorldComponent user={user}/>
        </>


    )
}

export default HelloWorldComponent;