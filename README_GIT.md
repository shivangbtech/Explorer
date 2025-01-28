# Create a new repository on the command line
echo "# Explorer" >> README.md
git init

git add README.md

git commit -m "first commit"

git branch -M main

git remote add origin `git ssh`

git push -u origin main

# Push an existing repository from the command line
git remote add origin `git ssh`

git branch -M main

git push -u origin main