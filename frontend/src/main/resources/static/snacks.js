const tabs = document.querySelectorAll('#tabs button');
const panels = document.querySelectorAll('.tab-panel');

if (tabs.length === 0 || panels.length === 0) {
    console.error("No se encontraron los tabs");
} else {
    
    const firstTab = tabs[0];
    const firstPanel = panels[0];

    if (firstTab && firstPanel) {
        firstTab.classList.add('active', 'border', 'border-white', 'text-custom-color');
        firstPanel.classList.add('block');
        firstPanel.classList.remove('hidden');
    }

    tabs.forEach((tab) => {
        tab.addEventListener('click', () => {
            const target = tab.getAttribute('data-tab-target');

            tabs.forEach((t) => t.classList.remove('active', 'border', 'border-transparent', 'text-custom-color'));
            tab.classList.add('active', 'border', 'border-white', 'text-custom-color'); 

            panels.forEach((panel) => {
                if (panel.getAttribute('data-tab') === target) {
                    panel.classList.remove('hidden');
                    panel.classList.add('block');
                } else {
                    panel.classList.remove('block');
                    panel.classList.add('hidden');
                }
            });
        });
    });
}
