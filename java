document.addEventListener("DOMContentLoaded", () => {
  init3DMenu();
  initCalendar();

  const sections = document.querySelectorAll("section");
  const observer = new IntersectionObserver(
    (entries) => {
      entries.forEach((entry) => {
        if (entry.isIntersecting) {
          entry.target.classList.add("in-view");
        } else {
          entry.target.classList.remove("in-view");
        }
      });
    },
    { threshold: 0.1 }
  );

  sections.forEach((section) => {
    observer.observe(section);
  });

  // Next button functionality
  document.getElementById("next-button").addEventListener("click", () => {
    const menuBox = document.querySelector("a-box");
    menuBox.style.display = "block"; // Show the 3D object
  });
});

function init3DMenu() {
  const scene = document.createElement("a-scene");
  const box = document.createElement("a-box");
  box.setAttribute("position", "0 1.5 -5");
  box.setAttribute("rotation", "0 45 0");
  box.setAttribute("color", "#74A57F");
  box.setAttribute(
    "animation",
    "property: rotation; to: 0 405 0; loop: true; dur: 3000; easing: easeInOutQuad"
  );
  box.style.display = "none";
  scene.appendChild(box);
  document.getElementById("3d-menu").appendChild(scene);
}

function initCalendar() {
  const calendar = document.createElement("div");
  calendar.textContent = "Events Calendar will be here";
  document.getElementById("calendar").appendChild(calendar);
}

