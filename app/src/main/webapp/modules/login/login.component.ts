login() {
  this.authService.login(this.loginForm.value).subscribe(
    (response) => {
      // Save token or session if needed
      this.router.navigate(['/admin']); // 👈 Redirect to dashboard
    },
    (error) => {
      console.error('Login failed', error);
    }
  );
}
