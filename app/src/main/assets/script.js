const tooltip = document.getElementById("tooltip"); // calling the tooltip from the html file
// a tooltip is a small area that can appear whenever you interact with an element in the web page
//code that shows the name of the nation (el)
document.querySelectorAll("path[data-name]").forEach(el => { //selecting every path

el.addEventListener("touchstart", e => {
tooltip.style.display = "block";
tooltip.style.left = (e.pageX - 30) + "px";
tooltip.style.top = (e.pageY - 30) + "px";
tooltip.textContent = el.getAttribute("data-name");
const touch=e.touches[0] // e=event of touch, touches= list of everything touching the screen (usually 1 finger, wich is the n.0)
    });

 el.addEventListener("touchend", () => {
        tooltip.style.display = "none";
    });

    el.addEventListener("click",(e)=>{  // listener for when a country is clicked (kotlin)
    const nome=el.getAttribute("data-name"); // constant: it's the name of the path clicked
   tooltip.style.display = "block";
    tooltip.style.left = (e.pageX - 30) + "px";
    tooltip.style.top = (e.pageY - 30) + "px";
    tooltip.textContent = nome
    if(typeof Android !== "undefined"){
    Android.onCountrySelected(nome);    //calls the function in main activity with the constant
    }
    });
});
tooltip.style.pointerEvents= "none" //makes it so that the tooltip doesnt  block the touch
const overlay = document.getElementById('overlay'); // variable who contains the reference to the background