sbt test
status=$?
echo "statusCode $status"
if [ $status -eq 0 ]; then
  echo "Tests passed successfully!"
else
  echo "Tests failed with exit code $status."
fi

