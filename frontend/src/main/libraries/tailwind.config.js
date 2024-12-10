module.exports = {
  content: ["../resources/templates/**/**.{html,js}"],
  theme: {
    extend: {
      colors: {
        primaryColor: '#FEF3F2',
        secondaryColor: '#314852',
      },
      fontFamily: {
        'plus-jakarta-sans': ['"Plus Jakarta Sans"', 'sans-serif'],
      },
      animation: {
        'loop-scroll': "loop-scroll 50s linear infinite",
      },
      keyframes: {
        "loop-scroll": {
          from: { transform: "translateX(0)" },
          to: { transform: "translateX(-100%)" },
        }
      },
    },
  },
  plugins: [],
}

