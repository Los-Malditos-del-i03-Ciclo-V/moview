/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["../resources/templates/**/**.{html,js}"],
  theme: {
    extend: {
      colors: {
          primaryColor: '#9DF1F1',
          secondaryColor: '#69C4CB',
          primaryHoverColor: '#8CFFFF',
        },
      fontFamily: {
        'plus-jakarta-sans': ['"Plus Jakarta Sans"', 'sans-serif'],
        'm-plus-rounded-1c': ['"M PLUS Rounded 1c"', 'sans-serif']
      }
    },
  },
  plugins: [],
}

